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
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortin saldon alussa pitäisi olla. Tarkasta koodi: "
                + "k = new Maksukortti(10);", 10, kortti.saldo(), 0.01);
    }
 
    @Test
    public void lataaminenKasvattaaKortinSaldoa() {
        kortti.lataaRahaa(10);
        String virhe = "Tomiiko rahan lataaminen? tarkasta koodi:\n"
                + "kortti = new Maksukortti(10); kortti.saldo()";
        assertEquals(virhe, 20, kortti.saldo(), 0.01);
    }

    @Test
    public void kortiltaVoiOttaaRahaaJosSaldoRittaa() {
        assertEquals("Jos kortilla raha riittää, pitäisi otaRahaa-metodin palauttaa true. Tarkasta koodi: \n"
                + "k = new Maksukortti(10); k.otaRahaa(8);", true, kortti.otaRahaa(8));
        assertEquals("Kortin saldon pitäisi vähetä kun rahaa otetaan. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(8);", 2, kortti.saldo(), 0.01);
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {
        assertEquals("Jos kortilla ei ole tarpeeksi rahaa, otaRahaa-metodin tulisi palauttaa false. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(11);", false, kortti.otaRahaa(11));
        assertEquals("Jos kortilla ei ole tarpeeksi rahaa, saldo ei muutu. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(11);", 10, kortti.saldo(), 0.01);
    }
}
