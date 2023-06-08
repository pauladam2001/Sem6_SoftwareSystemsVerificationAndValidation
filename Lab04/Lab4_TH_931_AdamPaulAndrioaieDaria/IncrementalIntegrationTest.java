package ssvv.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class IncrementalIntegrationTest
{
    // Lab 4

    String filenameStudent = "fisiere/Studenti.xml";
    String filenameTema = "fisiere/Teme.xml";
    String filenameNota = "fisiere/Note.xml";

    StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);

    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);

    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void saveStudent() {
        assertNull(service.addStudent(new Student("105", "nume", 10, "email@mail.com")));
    }

    @Test
    public void saveStudentTema() {
        Student student1 = service.addStudent(new Student("105", "nume", 10, "email@mail.com"));
        assertEquals(student1.getID(), "105");
        assertEquals(student1.getNume(), "nume");

        assertNull(service.addTema(new Tema("42", "asd", 12, 12)));
    }

    @Test
    public void saveStudentTemaNota() {
        Student student1 = service.addStudent(new Student("105", "nume", 10, "email@mail.com"));
        assertEquals(student1.getID(), "105");
        assertEquals(student1.getNume(), "nume");

        Tema tema1 = service.addTema(new Tema("42", "asd", 12, 12));
        assertEquals(tema1.getID(), "42");

        assertEquals(service.addNota(new Nota("38", "105", "42", Double.parseDouble("9"), LocalDate.now().minusDays(1570)), "la"), Double.parseDouble("9"), 1);
    }
}
