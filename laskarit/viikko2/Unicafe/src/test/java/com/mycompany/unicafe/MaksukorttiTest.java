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
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaOnTarpeeksi() {
        kortti.otaRahaa(5);
        assertEquals("Kortilla on rahaa 5.0 euroa", kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(15);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.saldo());
    }
    
    @Test
    public void metodiPalauttaaTrueJosRahatRiittivat() {
        kortti.otaRahaa(5);
        assertEquals(true, kortti.otaRahaa(5));
    } 
    
    @Test
    public void metodiPalauttaaFalseJosRahatEivatRiittaneet() {
        kortti.otaRahaa(15);
        assertEquals(false, kortti.otaRahaa(5));
    } 
    
}
