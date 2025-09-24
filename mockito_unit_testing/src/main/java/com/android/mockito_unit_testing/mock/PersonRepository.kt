package com.android.mockito_unit_testing.mock

class PersonRepository {

    val persons = listOf<Person>(
        Person(1, "John", "john@gmail.com", "2asdas1wq"),
        Person(2, "Wein", "wein@gmail.com", "34dd3s2po"),
        Person(3, "Emily", "emily@gmail.com", "1dfd2s12q"),
    )

    fun loginPerson(email: String, password: String): LOGIN_STATUS {

        //Fetch User From DB
        val person = persons.filter { person -> person.email == email }
        return if (persons.size == 1) {
            if (persons[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_PERSON
        }
    }
}