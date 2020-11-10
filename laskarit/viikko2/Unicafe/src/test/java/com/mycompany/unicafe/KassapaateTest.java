
package com.mycompany.unicafe;



import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(10);
    }
    
//    @After
//    public void tearDown() {
//    }
    
//    @Test
//    public void kassaAluksiRahaa1000() {
//        assertTrue("Kun kassapääte luodaan pitää rahamäärän muistavan oliomuuttujan arvoksi asettaa 1000. Olion tulostamalla pitäisi näytä että rahaa kassassa on 1000. \n"
//                + "Nyt tulostuu: \"" + kassa + "\"", kassa.toString().contains("kassassa rahaa 1000"));
//    }
    
     @Test
    public void alussaRahaa1000JaEiMyytyjaLounaita(){
        assertEquals("Kassasa pitäisi olla alussa 1000 rahaa. Tarkasta koodi: "
                + "k = new Kassapääte();", 100000, kassa.kassassaRahaa(), 0.01);
        assertEquals("Kun kassapääte luodaan myytyjen lounaiden määrä 0, ", 0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }
//    
//    @Test
//    public void alussaRahaa1000JaEiMyytyjaLounaita() {
//        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
//        assertEquals("Kun kassapääte luodaan on rahaa 1000 ja myytyjen lounaiden määrä 0, ", odotettu, kassa.toString());
//    }
    
    @Test
    public void onnistunutEdullinen() {
       // double vaihto = kassa.syoEdullisesti(4);

        String virhe = "Ostettaessa käteisellä 4:llä eurolla edullinen lounas (eli kutsuttaessa kassa.syoEdullisesti(4)) ";
        assertEquals(virhe + "pitäisi metodin palauttaa vaihtorahan oikea määrä.", 160, kassa.syoEdullisesti(400), 0.01);
        
        assertEquals("Kassassa olevan rahamäärän kasvaa 2.4 eurolla eli olla 1002.4 "
                + "k = new Kassapääte();", 100240, kassa.kassassaRahaa(), 0.01);
        
        assertEquals("Jos maksu on riittävä: myytyjen lounaiden määrä kasvaa 1, ", 1, kassa.edullisiaLounaitaMyyty());
        
        

//        assertTrue(virhe + " pitäisi kassassa olevan rahamäärän kasvaa 2.4 eurolla eli olla 1002.4. \nNyt kassa on: " + kassa, kassa.toString().contains("kassassa rahaa 1002.4"));
//
//        assertTrue(virhe + " pitäisi myytyjen edullisten lounaiden määrän olla 1. \n"
//                + "Nyt kassa on: " + kassa, kassa.toString().contains("edullisia lounaita myyty 1"));
//        assertTrue(virhe + " pitäisi myytyjen maukkaiden lounaiden määrän olla edelleen 0. Nyt kassa on: " + kassa, kassa.toString().contains("maukkaita lounaita myyty 0"));
//   
    }

    @Test
    public void onnistunutMaukas() {
        String virhe = "Ostettaessa käteisellä 4:llä eurolla maukas lounas (eli kutsuttaessa kassa.syoMaukkaasti(5)) ";
        assertEquals(virhe + "pitäisi metodin palauttaa vaihtorahan oikea määrä.", 100, kassa.syoMaukkaasti(500), 0.01);
       
        assertEquals("Kassassa olevan rahamäärän kasvaa 4.0 eurolla eli olla 1004.0 "
                + "k = new Kassapääte();", 100400, kassa.kassassaRahaa(), 0.01);
        
        assertEquals("Jos maksu on riittävä: myytyjen lounaiden määrä kasvaa 1, ", 1, kassa.maukkaitaLounaitaMyyty());
//        double vaihto = kassa.syoMaukkaasti(5);
//
//        String virhe = "Ostettaessa käteisellä 5:llä eurolla maukas lounas (eli kutsuttaessa kassa.syoMaukkaasti(5)) ";
//        assertEquals(virhe + "pitäisi metodin palauttaa vaihtorahan oikea määrä.", 1.0, vaihto, 0.01);
//
//        assertTrue(virhe + " pitäisi kassassa olevan rahamäärän kasvaa 4.0 eurolla eli olla 1004.0. \nNyt kassa on: " + kassa, kassa.toString().contains("kassassa rahaa 1004.0") || kassa.toString().contains("kassassa rahaa 1004.0"));
//
//        assertTrue(virhe + " pitäisi myytyjen maukkaiden lounaiden määrän olla 1. Nyt kassa on: " + kassa, kassa.toString().contains("maukkaita lounaita myyty 1"));
//        assertTrue(virhe + " pitäisi myytyjen edullisten lounaiden määrän olla edelleen 0. Nyt kassa on: " + kassa, kassa.toString().contains("edullisia lounaita myyty 0"));
//    
    }

    @Test
    public void josEiRahaaMyyntiEpaonnistuuEiKassaanKosketa() {
        String virhe = "Kun yritetään ostaa liian pienellä rahamäärällä eli kassa.syoEdullisesti(2), pitäisi koko raha palauttaa takaisin ";
        assertEquals(virhe + "pitäisi metodin palauttaa vaihtorahan oikea määrä.", 200, kassa.syoEdullisesti(200), 0.01);
        
        assertEquals("Kassassa olevan rahamäärän tulee pysyä samana eli olla 1000.0 "
                + "k = new Kassapääte();", 100000, kassa.kassassaRahaa(), 0.01);
        
        assertEquals("Jos maksu ei ole riittävä: myytyjen lounaiden määrä pysyy samana 0, ", 0, kassa.edullisiaLounaitaMyyty());
        
        
        String virhe1 = "Kun yritetään ostaa liian pienellä rahamäärällä eli kassa.syoMaukkaasti(2), pitäisi koko raha palauttaa takaisin ";
        assertEquals(virhe1 + "pitäisi metodin palauttaa vaihtorahan oikea määrä.", 200, kassa.syoMaukkaasti(200), 0.01);
        
        assertEquals("Kassassa olevan rahamäärän tulee pysyä samana eli olla 1000.0 "
                + "k = new Kassapääte();", 100000, kassa.kassassaRahaa(), 0.01);
        
        assertEquals("Jos maksu ei ole riittävä: myytyjen lounaiden määrä pysyy samana 0, ", 0, kassa.maukkaitaLounaitaMyyty());
        
        
//        
//        double paluu = kassa.syoEdullisesti(2);
//
//        assertEquals("Kun yritetään ostaa liian pienellä rahamäärällä eli kassa.syoEdullisesti(2), pitäisi koko raha palauttaa takaisin", 2, paluu, 0.01);
//
//        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
//        assertEquals("Kun tyhjästä kassata yritetään ostaa riittämättömällä rahamäärällä edullinen lounas, "
//                + "ei kassan sisältö saisi muuttua eli tulostuksen pitäisi olla: ", odotettu, kassa.toString());
//
//        paluu = kassa.syoMaukkaasti(2);
//        assertEquals("Kun yritetään ostaa liian pienellä rahamäärällä eli kassa.syoMaukkaasti(2), pitäisi koko raha palauttaa takaisin", 2, paluu, 0.01);
//
//        odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
//        assertEquals("Kun tyhjästä kassata yritetään ostaa riittämättömällä rahamäärällä maukas lounas, "
//                + "ei kassan sisältö saisi muuttua eli tulostuksen pitäisi olla: ", odotettu, kassa.toString());
    }
    
    @Test
    public void kortillaVoiOstaaEdullisenLounaanJosTarpeeksiRahaa() {
        String sken = "kassa = new Kassapaate(); kortti = new Maksukortti(10); kassa.syoEdullisesti(kortti);";
   //     Boolean ok = syoEdullisesti(kassa, kortti);

        assertEquals("Kortilla pitäisi voida ostaa edullinen lounas jos raha riittää. Tarkasta seuraava:\n" + sken, true);

        assertEquals("Kortin saldon pitäisi vähetä lounaan hinnan verran. Tarkasta koodi:\n"
                + sken + " kortti.saldo();\n", 760, kortti.saldo(), 0.01);

        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 1 maukkaita lounaita myyty 0";
        assertEquals("Kun tyhjästä kassata ostetaan kortilla edullinen lounas, kassan rahasumma ei saa muuttua ja"
                + " myytyjen edullisten lounaiden pitäisi olla 1.\n", odotettu, kassa.toString());
    }
    
    @Test
    public void kortillaEiVoiOstaaEdullistaJosEiTarpeeksiRahaa() {
        String sken = "kassa = new Kassapaate(); kortti = new Maksukortti(2); kassa.syoEdullisesti(kortti);";
        kortti = new Maksukortti(2);
       // Boolean ok = syoEdullisesti(kassa, kortti);

        assertEquals("Kortilla ei saa voida ostaa jos rahaa ei riittävästi. Tarkasta seuraava:\n"
                + sken + "\n", false);

        assertEquals("Kortin saldon pitäisi pysyä lmuuttumattomana jos ostokseen ei rahaa. Tarkasta koodi:\n"
                + sken + " kortti.saldo();\n", 200, kortti.saldo(), 0.01);

        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
        assertEquals("Kun tyhjästä kassata ostetaan kortilla jolla ei rahaa, pysyy kassan tilanne muuttumattomana.",
                odotettu, kassa.toString());
    }
    
    
    @Test
    public void kortillaVoiOstaaMaukkaanLounaanJosTarpeeksiRahaa() {
        String sken = "kassa = new Kassapaate(); kortti = new Maksukortti(10); kassa.syoMaukkaasti(kortti);";
      //  Boolean ok = syoMaukkaasti(kassa, kortti);

        assertEquals("Kortilla pitäisi voida ostaa maukas lounas jos raha riittää. Tarkasta seuraava: " + sken + " "
                + "\n", true);

        assertEquals("Kortin saldon pitäisi vähetä maukkaan lounaan hinnan verran. \n"
                + "Tarkasta koodi "
                + sken + " kortti.saldo();\n", 6.0, kortti.saldo(), 0.01);

        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 1";
        assertEquals("Kun tyhjästä kassata ostetaan kortilla maukas lounas, kassan rahasumma ei saa muuttua ja"
                + "myytyjen maukkaiden lounaiden pitäisi olla 1.\n", odotettu, kassa.toString());
    }
    
    @Test
    public void kortillaEiVoiOstaaMaukastaJosEiTarpeeksiRahaa() {
        String sken = "kassa = new Kassapaate(); kortti = new Maksukortti(4);";
        kortti = new Maksukortti(3);
     //   Boolean ok = syoMaukkaasti(kassa, kortti);

        assertEquals("Kortilla ei saa voida ostaa jos rahaa ei riittävästi. Tarkasta seuraava:\n"
                + sken + "\n", false);

        assertEquals("Kortin saldon pitäisi pysyä muuttumattomana jos ostokseen ei rahaa. Tarkasta koodi:\n"
                + sken + " kortti.saldo();\n", 3.0, kortti.saldo(), 0.01);

        String odotettu = "kassassa rahaa 1000.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
        assertEquals("Kun tyhjästä kassata ostetaan kortilla jolla ei rahaa, pysyy kassan tilanne muuttumattomana.",
                odotettu, kassa.toString());
    }

    @Test
    public void lataaminenKasvattaaKortinSaldoa() {
        kortti.lataaRahaa(10);
//        String virhe = "Tomiiko rahan lataaminen? tarkasta koodi:\n"
//                + "kassa = new Kassapaate(); kortti = new Maksukortti(10); kassa.lataaRahaaKortille(kortti, 10); kortti.saldo()";
//        assertEquals(virhe, 20, kortti.saldo(), 0.01);
//        
        assertEquals("Kortilla olevan rahamäärän tulee kasvaa 10.0 eurolla eli olla 20.0 "
                + "k = new Kassapääte();", 20, kortti.saldo(), 0.01);
        
        assertEquals("Kassassa olevan rahamäärän tulee myös kasvaa 10.0 eurolla eli olla 1010.0 "
                + "k = new Kassapääte();", 100010, kassa.kassassaRahaa()+10, 0.01);

//        String odotettu = "kassassa rahaa 1010.0 edullisia lounaita myyty 0 maukkaita lounaita myyty 0";
//        assertEquals("Kun kortille ladataan rahaa, menee ladattu rahamäärä Kassapäätteeseen. "
//                + "Alussa kassassa siis 1000, kun kortille ladataan 10"
//                + " pitäisi kassan tulostuksen olla: \n", odotettu, kassa.toString());

    }
    
    
    
//        private void lataa(Object kassa, Object kortti, double summa) {
//        String metodiNimi = "lataaRahaaKortille";
//        try {
//            Method metodi = ReflectionUtils.requireMethod(Kassapaate.class, metodiNimi, Maksukortti.class, double.class);
//            ReflectionUtils.invokeMethod(void.class, metodi, kassa, kortti, summa);
//        } catch (Throwable t) {
//            t.printStackTrace();
//            fail("tee luokalle Kassapaate metodi public boolean lataaRahaaKortille(Maksukortti kortti, double summa)");
//        }
//    }
//
//    private boolean syoEdullisesti(Object kassa, Object kortti) {
//        String metodiNimi = "syoEdullisesti";
//        try {
//            Method metodi = ReflectionUtils.requireMethod(Kassapaate.class, metodiNimi, Maksukortti.class);
//            return ReflectionUtils.invokeMethod(boolean.class, metodi, kassa, kortti);
//        } catch (Throwable t) {
//            t.printStackTrace();
//            fail("tee luokalle Kassapaate metodi public boolean syoEdullisesti(Maksukortti kortti)");
//        }
//        return false;
//    }
//
//    private boolean syoMaukkaasti(Object kassa, Object kortti) {
//        String metodiNimi = "syoMaukkaasti";
//        try {
//            Method metodi = ReflectionUtils.requireMethod(Kassapaate.class, metodiNimi, Maksukortti.class);
//            return ReflectionUtils.invokeMethod(boolean.class, metodi, kassa, kortti);
//        } catch (Throwable t) {
//            t.printStackTrace();
//            fail("tee luokalle Kassapaate metodi public boolean syoMaukkaasti(Maksukortti kortti)");
//        }
//        return false;
//    }
//
    

}



