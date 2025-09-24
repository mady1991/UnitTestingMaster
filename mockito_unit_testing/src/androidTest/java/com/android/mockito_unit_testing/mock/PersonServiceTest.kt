package com.android.mockito_unit_testing.mock

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class PersonServiceTest {

    @Mock
    lateinit var personRepository: PersonRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(personRepository.loginPerson(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PERSON)

    }

    @Test
    fun testLoginPerson() {
        val personService = PersonService(personRepository)
        val result = personService.loginPerson("john@gmail.com", "2asdas1wq")
        assertEquals("Person does not exist", result)
    }

    @Test
    fun testLoginPerson_InvalidPassword() {
        val personService = PersonService(personRepository)
        val result = personService.loginPerson("wein@gmail.com", "2asdas1wq")
        assertEquals("Password is invalid", result)
    }

    @Test
    fun testLoginPerson_UnknownError() {
        val personService = PersonService(personRepository)
        val result = personService.loginPerson("emily@gmail.com", "2asdas1wq")
        assertEquals("Unknown error occurred", result)
    }

    @Test
    fun testLoginPerson_Success() {
        val personService = PersonService(personRepository)
        val result = personService.loginPerson("john@gmail.com", "2asdas1wq")
        assertEquals("Logged in successfully", result)
    }

    @Test
    fun testLoginPerson_InvalidPerson() {
        val personService = PersonService(personRepository)
        val result = personService.loginPerson("john@gmail.com", "2asdas1wq")
        assertEquals("Person does not exist", result)
    }


}