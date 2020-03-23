package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoOnOikein() {
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
    @Test
    public void rahanLaittaminenKasvattaaKortinSaldoa() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20",kortti.toString());
    }
    
    @Test
    public void rahanOttaminenVahentaaSaldoa() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0",kortti.toString());
    }
    @Test
    public void rahanOttaminenEiSaaKortinSaldoaNegatiiviseksi() {
        kortti.otaRahaa(2000);
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
    @Test
    public void otaRahaMetodiToimiiOikein() {
        assertEquals(true,kortti.otaRahaa(10));
        assertEquals(false,kortti.otaRahaa(20));
    }
    
    @Test
    public void metoditSaldoToimiiOikein() {
        assertEquals(10,kortti.saldo());
    }
    
    
}
