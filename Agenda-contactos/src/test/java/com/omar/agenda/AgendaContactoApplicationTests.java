package com.omar.agenda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omar.agenda.controllers.ContactoController;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.omar.agenda.domian.Contacto;
import com.omar.agenda.service.ContactoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@WebMvcTest(ContactoController.class)
class AgendaContactoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactoService service;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenContact_whenGetContactById_thenReturnContact() throws Exception {
        Contacto contacto = crearContacto();

        given(service.findContact(1L)).willReturn(Optional.of(contacto));
        var findById = mockMvc.perform(
                        get("/agenda/find/1")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        var b = objectMapper.readValue(findById.getResponse().getContentAsString(), Contacto.class);
        assert b.getNombreCompleto().equalsIgnoreCase("Maria Mendez");
    }

    @Test
    public void whenPostContact_thenCreateContact() throws Exception {
        Contacto contacto = crearContacto();
        given(service.save(Mockito.any())).willReturn(contacto);

        mockMvc.perform(post("/agenda/add").contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(contacto))).andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombreCompleto", is("Maria Mendez")));
        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(service);
    }

    @Test
    public void givenContacts_whenGetContacts_thenReturnJsonArray() throws Exception {
        Contacto contacto = crearContacto();

        List<Contacto> allContacts = Arrays.asList(contacto);

        given(service.list()).willReturn(allContacts);

        mockMvc.perform(get("/agenda/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is(contacto.getEmail())))
                .andExpect(jsonPath("$[0].telefono", is(contacto.getTelefono())))
                .andExpect(jsonPath("$[0].relacion", is(contacto.getRelacion())));
        verify(service, VerificationModeFactory.times(1)).list();
        reset(service);
    }

    private Contacto crearContacto(){
        Contacto contacto = new Contacto();
        contacto.setNombreCompleto("Maria Mendez");
        contacto.setDireccion("cra 4 clle 4 -125");
        contacto.setEmail("karolinamen25@hotmail.com");
        contacto.setTelefono("3225172612");
        contacto.setRelacion("Esposa");
        contacto.setTipoRelacion("Familiar");
        return contacto;
    }

}

class JsonUtil {
    static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
