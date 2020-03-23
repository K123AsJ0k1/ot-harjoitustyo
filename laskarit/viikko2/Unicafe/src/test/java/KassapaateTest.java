/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niila
 */
public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti kortti;
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti=new Maksukortti(1000);
    }

    @Test
    public void kassapaateKonstruktoriOnOikea() {
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassapaateKasvaaJosSyoEdullisesti() {
        kassapaate.syoEdullisesti(400);
        assertEquals(100240,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassapaateKasvaaJosSyoMakeasti() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400,kassapaate.kassassaRahaa());
    }
    @Test
    public void kassapaateenAntamaVaihtoRahaOnOikeaJosSyoEdullisesti() {
        assertEquals(760,kassapaate.syoEdullisesti(1000));
    }
    
    @Test
    public void kassapaateenAntamaVaihtoRahaOnOikeaJosSyoMaukkaasti() {
        assertEquals(600,kassapaate.syoMaukkaasti(1000));
    }
    
    @Test
    public void lounaidenMaaraKasvaaJosSyoEdullisesti() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void lounaidenMaaraKasvaaJosSyoMaukkaasti() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josYritetaanSyodaEdullisestiMuttaRahaaEiOle() {
        assertEquals(200,kassapaate.syoEdullisesti(200));
        assertEquals(100000,kassapaate.kassassaRahaa());
        assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josYritetaanSyodaMaukkaastiMuttaRahaaEiOle() {
        assertEquals(300,kassapaate.syoMaukkaasti(300));
        assertEquals(100000,kassapaate.kassassaRahaa());
        assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test 
    public void korttiOstoToimiiKunSyodaanEdullisesti() {
        assertEquals(true,kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiOstoToimiiKunSyodaanMaukkaasti() {
        assertEquals(true,kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void lounaidenMaaraKasvaaKunKortillaSyodaanEdullisesti() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void lounaidenMaaraKasvaaKunKortillaSyodaanMaukkaasti() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaEiOleRahaaKunSyodaanEdullisesti() {
        kortti.otaRahaa(900);
        assertEquals(false,kassapaate.syoEdullisesti(kortti));
        assertEquals(100,kassapaate.syoEdullisesti(100));
        assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaEiOleRahaaKunSyodaanMaukkaasti() {
        kortti.otaRahaa(900);
        assertEquals(false,kassapaate.syoMaukkaasti(kortti));
        assertEquals(100,kassapaate.syoMaukkaasti(100));
        assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaSyodaanEdullisestiNiinKassanRahamaaraEiMuutu() {
        assertEquals(true,kassapaate.syoEdullisesti(kortti));
        assertEquals(100000,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void josKortillaSyodaanMaukkaastiNiinKassanRahamaaraEiMuutu() {
        assertEquals(true,kassapaate.syoMaukkaasti(kortti));
        assertEquals(100000,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLatausToimii() {
        kassapaate.lataaRahaaKortille(kortti, 400);
        assertEquals(100400,kassapaate.kassassaRahaa());
        assertEquals(1400,kortti.saldo());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivisiaSummia() {
        kassapaate.lataaRahaaKortille(kortti, -400);
        assertEquals(100000,kassapaate.kassassaRahaa());
        assertEquals(1000,kortti.saldo());
    }
     
}
