package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.students.IStudentRepository;
import code.example.responses.students.StudentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void testGetStudentByGroupId_Success() throws RepositoryException, ServiceException {
        // Arrange
        long groupId = 1L;
        List<StudentEntity> studentEntities = Arrays.asList(
                new StudentEntity(1L, "John Doe", groupId),
                new StudentEntity(2L, "Jane Smith", groupId)
        );
        when(studentRepository.getStudentsByGroup(groupId)).thenReturn(studentEntities);

        // Act
        List<StudentResponse> responses = studentService.getStudentByGroupId(groupId);

        // Assert
        assertNotNull(responses);
        assertEquals(2, responses.size());
        verify(studentRepository, times(1)).getStudentsByGroup(groupId);
    }

    @Test
    void testGetStudentByGroupId_ThrowsServiceException() throws RepositoryException {
        // Arrange
        long groupId = 1L;
        when(studentRepository.getStudentsByGroup(groupId)).thenThrow(new RepositoryException("Database error"));

        // Act & Assert
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            studentService.getStudentByGroupId(groupId);
        });
        assertEquals("Failed to retrieve students by group id:1", exception.getMessage());
        verify(studentRepository, times(1)).getStudentsByGroup(groupId);
    }

    @Test
    void testGetStudentById_Success() throws RepositoryException, ServiceException {
        // Arrange
        long studentId = 1L;
        StudentEntity studentEntity = new StudentEntity(studentId, "John Doe", 1L);
        when(studentRepository.getStudentById(studentId)).thenReturn(studentEntity);

        // Act
        StudentResponse response = studentService.getStudentById(studentId);

        // Assert
        assertNotNull(response);
        assertEquals(studentId, response.getId());
        verify(studentRepository, times(1)).getStudentById(studentId);
    }

    @Test
    void testAddStudent_Success() throws RepositoryException, ServiceException {
        // Arrange
        StudentEntity studentEntity = new StudentEntity(1L, "John Doe", 1L);
        when(studentRepository.addStudent(studentEntity)).thenReturn(1L);

        // Act
        long studentId = studentService.addStudent(studentEntity);

        // Assert
        assertEquals(1L, studentId);
        verify(studentRepository, times(1)).addStudent(studentEntity);
    }

    @Test
    void testDeleteStudent_Success() throws RepositoryException, ServiceException {
        // Arrange
        long studentId = 1L;

        // Act
        studentService.deleteStudent(studentId);

        // Assert
        verify(studentRepository, times(1)).deleteStudent(studentId);
    }

    @Test
    void testDeleteStudent_ThrowsServiceException() throws RepositoryException {
        // Arrange
        long studentId = 1L;
        doThrow(new RepositoryException("Database error")).when(studentRepository).deleteStudent(studentId);

        // Act & Assert
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            studentService.deleteStudent(studentId);
        });
        assertEquals("Error deleting student with ID: 1", exception.getMessage());
        verify(studentRepository, times(1)).deleteStudent(studentId);
    }
}
