package com.sp.service;
  import org.springframework.stereotype.Service;

  import com.sp.model.Hero;

  @Service
  public class HeroService {
      
      public void addHero(Hero h) {
          System.out.println(h);
      }
      
      public Hero getHero(int id) {
          Hero h = new Hero(2, "Flash", "VeryFast", 20, "http://fairedesgifs.free.fr/da/sh/flash/flash-(4).gif");
          return h;
      }

  }
