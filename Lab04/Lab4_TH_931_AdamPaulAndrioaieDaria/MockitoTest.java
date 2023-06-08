package ssvv.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.w3c.dom.Element;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MockitoTest
{
    // Lab 4

    @Mock
    private StudentXMLRepo studentXMLRepository;

    @Mock
    private TemaXMLRepo temaXMLRepository;

    @InjectMocks
    private Student student;

    @InjectMocks
    private Tema tema;


//    String filenameStudent = "fisiere/Studenti.xml";
//    String filenameTema = "fisiere/Teme.xml";
//    String filenameNota = "fisiere/Note.xml";
//
//    StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
//    TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
//    NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
//
//    StudentValidator studentValidator = new StudentValidator();
//    TemaValidator temaValidator = new TemaValidator();
//    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
//
//    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Before
    public void setup() {
//        studentXMLRepository = mock(StudentXMLRepo.class);
//        temaXMLRepository = mock(TemaXMLRepo.class);

        student = new Student("12345", "John Doe", 1, "johndoe@example.com");
        tema = new Tema("1234", "asd", 12, 12);
    }

    @Test
    public void testStudentAndTema() {
        try {
            when(studentXMLRepository.extractEntity(any(Element.class))).thenReturn(student);
            assertEquals("12345", student.getID());

            when(temaXMLRepository.extractEntity(any(Element.class))).thenReturn(tema);
            assertEquals("1234", tema.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNota() {
        try {
            when(studentXMLRepository.extractEntity(any(Element.class))).thenReturn(student);

            when(temaXMLRepository.extractEntity(any(Element.class))).thenReturn(tema);

            String filenameStudent = "fisiere/Studenti.xml";
            String filenameTema = "fisiere/Teme.xml";
            String filenameNota = "fisiere/Note.xml";

            NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);

            StudentValidator studentValidator = new StudentValidator();
            TemaValidator temaValidator = new TemaValidator();
            NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);

            Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

            assertEquals(service.addNota(new Nota("38", "12345", "1234", Double.parseDouble("9"), LocalDate.now().minusDays(1570)), "la"), Double.parseDouble("9"), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//
//    @Test
//    public void saveStudent() {
//        assertNull(service.addStudent(new Student("105", "nume", 10, "email@mail.com")));
//    }
//
//    @Test
//    public void saveStudentTema() {
//        Student student1 = service.addStudent(new Student("105", "nume", 10, "email@mail.com"));
//        assertEquals(student1.getID(), "105");
//        assertEquals(student1.getNume(), "nume");
//
//        assertNull(service.addTema(new Tema("42", "asd", 12, 12)));
//    }
//
//    @Test
//    public void saveStudentTemaNota() {
//        Student student1 = service.addStudent(new Student("105", "nume", 10, "email@mail.com"));
//        assertEquals(student1.getID(), "105");
//        assertEquals(student1.getNume(), "nume");
//
//        Tema tema1 = service.addTema(new Tema("42", "asd", 12, 12));
//        assertEquals(tema1.getID(), "42");
//
//        assertEquals(service.addNota(new Nota("38", "105", "42", Double.parseDouble("9"), LocalDate.now().minusDays(1570)), "la"), Double.parseDouble("9"), 1);
//    }
}
