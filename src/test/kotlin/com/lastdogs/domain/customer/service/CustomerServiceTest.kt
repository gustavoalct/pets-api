package com.lastdogs.domain.customer.service

import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.secundary.port.CustomerDataAccess
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import java.util.*

@ExtendWith()
internal class CustomerServiceTest (

    @InjectMocks
    val customerService:CustomerService,

    @Mock
    val accountDataAccess: CustomerDataAccess,

    //@Captor   // exemplo captura uma alteracao no meio do metodo e dps vc vai salvar
                // o captor permite capturar o valor e testa-lo se foi editado
    //val valorCaptor: tipo

){



    @Test
    @DisplayName("create account customer success")
    fun createAccountSuccess() {

        // montar setup ou mock ARRANGE
        val customer = Customer(UUID.randomUUID(), "teste", "teste@gmail.com", "123456")
        Mockito.`when`(accountDataAccess.getCustomerByEmail(customer.email)).thenReturn(customer)


        //teste ACTION
        customerService.create(customer)

        //validacoes ASSERTIONS
        Mockito.verify(accountDataAccess).getCustomerByEmail(customer.email)

        // validar o valor
        //Mockito.verify(accountDataAccess).createAccount(valorCaptor)
        // val valorCaptor:tipo = valor.getValue()


        Mockito.verify(accountDataAccess).createAccount(customer)
        val customerSave:Customer = customer
        //Assertions.assertAll(customerSave.userName).equals(null)

    }
}