package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.AlkatreszWithWarehouseDTO;
import hu.kosztaauto.partshop.model.Alkatresz;
import hu.kosztaauto.partshop.model.Raktar;
import hu.kosztaauto.partshop.repository.AlkatreszRepository;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class AlkatreszServiceTest {

    @InjectMocks
    private AlkatreszService alkatreszService;

    @Mock
    private AlkatreszRepository alkatreszRepository;

    @Mock
    private RaktarRepository raktarRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void testConvertToAlkatreszDTOShouldReturnAlkatreszDTO() {
        //given
        Alkatresz alkatresz = new Alkatresz(
                "cikkszam","megnevezes","autotipus",1000
        );

        //when
        AlkatreszDTO alkatreszDTO = alkatreszService.convertToAlkatreszDTO(alkatresz);

        //then
        Assertions.assertEquals(alkatresz.getCikkszam(), alkatreszDTO.getCikkszam());
        Assertions.assertEquals(alkatresz.getMegnevezes(), alkatreszDTO.getMegnevezes());
        Assertions.assertEquals(alkatresz.getAutoTipus(), alkatreszDTO.getAutoTipus());
        Assertions.assertEquals(alkatresz.getAr(), alkatreszDTO.getAr());
    }
}
