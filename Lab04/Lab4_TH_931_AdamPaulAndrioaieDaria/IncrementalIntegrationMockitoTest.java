package ssvv.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IncrementalIntegrationMockitoTest {

    @Mock
    StudentXMLRepo studentXMLRepository; // Mock object for StudentXMLRepo
    @Mock
    TemaXMLRepo temaXMLRepository; // Mock object for TemaXMLRepo
    @Mock
    NotaXMLRepo notaXMLRepository; // Mock object for NotaXMLRepo

    StudentValidator studentValidator;
    TemaValidator temaValidator;
    NotaValidator notaValidator;

    Service service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize the mock objects

        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();
        notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);

        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator,
                notaXMLRepository, notaValidator);
    }

    @Test
    public void saveStudent() {
        // Arrange
        Student student = new Student("105", "nume", 10, "email@mail.com");
        Mockito.when(studentXMLRepository.save(student)).thenReturn(null);

        // Act
        Student result = service.addStudent(student);

        // Assert
        assertNull(result);
    }

    @Test
    public void saveStudentTema() {
        // Arrange
        Student student = new Student("105", "nume", 10, "email@mail.com");
        Tema tema = new Tema("42", "asd", 12, 12);
        Mockito.when(studentXMLRepository.save(student)).thenReturn(student);
        Mockito.when(temaXMLRepository.save(tema)).thenReturn(null);

        // Act
        Student student1 = service.addStudent(student);
        Tema tema1 = service.addTema(tema);

        // Assert
        assertEquals(student1.getID(), "105");
        assertEquals(student1.getNume(), "nume");
        assertNull(tema1);
    }

    @Test
    public void saveStudentTemaNota() {
        // Arrange
        Student student = new Student("105", "nume", 10, "email@mail.com");
        Tema tema = new Tema("42", "asd", 12, 12);
        Nota nota = new Nota("38", "105", "42", Double.parseDouble("9"), LocalDate.now().minusDays(1570));
        Mockito.when(studentXMLRepository.save(student)).thenReturn(student);
        Mockito.when(temaXMLRepository.save(tema)).thenReturn(tema);
        Mockito.when(notaXMLRepository.save(nota)).thenReturn(nota);

        // Act
        Student student1 = service.addStudent(student);
        Tema tema1 = service.addTema(tema);
        Double notaValue = service.addNota(nota, "la");

        // Assert
        assertEquals(student1.getID(), "105");
        assertEquals(student1.getNume(), "nume");
        assertEquals(tema1.getID(), "42");
        assertEquals(notaValue, Double.parseDouble("9"), 1);
    }
}