package fr.univ_orleans.iut45.menus;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;


public class AppTest
{
    @Test
    public void testPrixPlats()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<String> allergenes_pb = new ArrayList<String>();
        allergenes_pb.add("gluten");
        allergenes_pb.add("fruits à coque");
        Plat paris_brest = new Plat ("Paris-Brest", false, allergenes_pb, 2.5);
        assertTrue(carottes_rapees.prixDeRevient() < paris_brest.prixDeRevient());
    }

    @Test
    public void testListeEntrees()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<Plat> les_entrees = new ArrayList<Plat>();
        les_entrees.add(carottes_rapees);
        Menu ce_midi = new Menu(les_entrees, new ArrayList<Plat>(), new ArrayList<Plat>());
        assertEquals(1, ce_midi.getEntrees().size());
    }

    @Test
    public void testMenuComplet()
    {
        Plat carottes_rapees = new Plat("Carottes Rapées", false, new ArrayList<String>(), 0.5);
        ArrayList<Plat> les_entrees = new ArrayList<Plat>();
        les_entrees.add(carottes_rapees);
        Menu ce_midi = new Menu(les_entrees, new ArrayList<Plat>(), new ArrayList<Plat>());
        assertEquals(false, ce_midi.estComplet());

        ArrayList<String> allergenes_pb = new ArrayList<String>();
        allergenes_pb.add("gluten");
        allergenes_pb.add("fruits à coque");
        Plat paris_brest = new Plat ("Paris-Brest", false, allergenes_pb, 2.5);
        ArrayList<Plat> les_desserts = new ArrayList<Plat>();
        les_desserts.add(paris_brest);

        ArrayList<String> allergenes_lasagnes = new ArrayList<String>();
        ArrayList<String> allergenes_tortilla = new ArrayList<String>();
        allergenes_lasagnes.add("gluten");
        allergenes_tortilla.add("oeufs");
        Plat lasagnes = new Plat("Lasagnes", true, allergenes_lasagnes, 2.8);
        Plat tortilla = new Plat("Tortilla", false, allergenes_tortilla, 1.8);
        ArrayList<Plat> les_plats_principaux = new ArrayList<Plat>();
        les_plats_principaux.add(lasagnes);
        les_plats_principaux.add(tortilla);
        Menu ce_soir = new Menu(les_entrees, les_plats_principaux, les_desserts);
        assertTrue(ce_soir.estComplet());
    }

@Test
public void testPrixMenu() {

    Plat carottes = new Plat("Carottes Rapées", false, new ArrayList<>(), 0.5);
    Plat saumon = new Plat("Saumon Fumé", false, Arrays.asList("poisson"), 4.5);
    Plat soupe = new Plat("Soupe à l'oignon", false, Arrays.asList("gluten"), 2.0);

    ArrayList<Plat> les_entrees = new ArrayList<>();
    les_entrees.add(carottes);
    les_entrees.add(saumon);
    les_entrees.add(soupe);

    Plat pates = new Plat("Pâtes Pesto", false, Arrays.asList("gluten", "fruits à coque"), 3.0);
    Plat steak = new Plat("Steak Frites", true, new ArrayList<>(), 8.5);
    Plat risotto = new Plat("Risotto Champignons", false, Arrays.asList("lactose"), 5.5);

    ArrayList<Plat> les_plats = new ArrayList<>();
    les_plats.add(pates);
    les_plats.add(steak);
    les_plats.add(risotto);


    Plat pomme = new Plat("Pomme", false, new ArrayList<>(), 0.8);
    Plat fondant = new Plat("Fondant Chocolat", false, Arrays.asList("oeufs", "lactose"), 4.0);
    Plat glace = new Plat("Glace Vanille", false, Arrays.asList("lactose"), 2.2);

    ArrayList<Plat> les_desserts = new ArrayList<>();
    les_desserts.add(pomme);
    les_desserts.add(fondant);
    les_desserts.add(glace);
    Menu menuTest = new Menu(les_entrees, les_plats, les_desserts);

    assertEquals(4.3, menuTest.getPrixRevientMin(), 0.01);
    assertEquals(17.0, menuTest.getPrixRevientMax(), 0.01);
}
}
