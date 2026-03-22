package com.stevanjaramillo.test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    @BeforeAll
    static void initAll() {
        System.out.println("Initializing PlayerTest");
    }

    //===>metodo de inicializacion @BeforeEach and @AfterEach<===
    @BeforeEach
    void setUp(){
        player = new Player("Steve",100,20);
    }
    @AfterEach
    void tearDown(){
        player = null;
    }
    /*====================>TEST<=========================*/
    @Test
    void constructorInicializaCampoCorrectamente(){
    assertEquals("Steve",player.getNombre());
    assertEquals(100,    player.getVida());
    assertEquals(20,     player.getAtaque());
    }
    @Test
    void constructorNoPermiteVidaNegativa(){
        assertThrows(IllegalArgumentException.class, ()->new Player("Steve",-10,10));
    }
    @Test
    void constructorNoPermiteAtaqueNegativo(){
        assertThrows(IllegalArgumentException.class, ()->new Player("Steve",100,-10));
    }
    //===================>TEST CURAR<==========================
    @Test
    void curarSumaVida(){
        Player player = new Player("Steve",20,10);
        player.curar(30); // vida =20 + 30 = 50
        //probar que cura correctamente
        assertEquals(50,player.getVida());
    }
    @Test
    void curarHastaMaximoExacto(){
        Player player=new Player("Steve",80,10);
        player.curar(20);
        //Probamos que no se hasta el  maximo
        assertEquals(100,player.getVida());
    }
    @Test
    void curarAUnMuertoNoFunciona(){
        Player player=new Player("Steve",100,10);
        //probamos que no se cura cuando esta muerto
        player.recibirDanyo(100);
        player.curar(100);
        assertEquals(0,player.getVida());
    }
    @Test
    void CurarNoSuperaMaximo(){
        Player player=new Player("Steve",100,10);
        player.curar(50);
        //probamos que curar no supera mas de 100(max)
        assertEquals(100,player.getVida());
    }

    //===============>TEST RECIBIR DAÑO<=================================

    @Test
    void recibirDañoReduceVida(){
        Player player=new Player("Steve",100,10);
        player.recibirDanyo(20);
        assertEquals(80,player.getVida());
    }
    @Test
    void recibirDañoCeroNoReduceVida(){
        Player player=new Player("Steve",100,10);
        player.recibirDanyo(0);
        assertEquals(100,player.getVida());
    }

    @Test
    void recibirDañoNuncaDejaVidaNegativa(){
        Player player=new Player("Steve",100,10);
        player.recibirDanyo(1000);
        assertEquals(0,player.getVida());
        assertTrue(player.getVida() >=0);
    }
    @Test
    void recibirDañoAcomuladoReduceVidaProgresivamente(){
        Player player=new Player("Steve",100,10);
        player.recibirDanyo(20);
        player.recibirDanyo(10);
        assertEquals(70,player.getVida());
    }



}