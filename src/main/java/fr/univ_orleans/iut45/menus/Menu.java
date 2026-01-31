cpackage fr.univ_orleans.iut45.menus;

import java.util.List;

class Menu {
    protected List<Plat> entrees;
    protected List<Plat> plats_principaux;
    protected List<Plat> desserts;

    public Menu(List<Plat> entrees,
            List<Plat> plats_principaux,
            List<Plat> desserts) {
        this.entrees = entrees;
        this.plats_principaux = plats_principaux;
        this.desserts = desserts;
    }

    public List<Plat> getEntrees() {
        return this.entrees;
    }

    public List<Plat> getPlatsPrincipaux() {
        return this.plats_principaux;
    }

    public List<Plat> getDesserts() {
        return this.desserts;
    }

    public double getPrixRevientMin() {
        double minE = entrees.get(0).prixDeRevient();
        for (Plat p : entrees) {

            if (p.prixDeRevient() < minE)
                minE = p.prixDeRevient();

        }
        double minP = plats_principaux.get(0).prixDeRevient();
        for (Plat p : plats_principaux) {
            if (p.prixDeRevient() < minP)
                minP = p.prixDeRevient();
        }
        double minD = desserts.get(0).prixDeRevient();
        for (Plat p : desserts) {

            if (p.prixDeRevient() < minD)
                minD = p.prixDeRevient();

        }
        return minE + minP + minD;
    }

    public double getPrixRevientMax() {
        double maxE = entrees.get(0).prixDeRevient();
        for (Plat p : entrees) {
            if (p.prixDeRevient() > maxE)
                maxE = p.prixDeRevient();

        }
        double maxP = plats_principaux.get(0).prixDeRevient();
        for (Plat p : plats_principaux) {
            if (p.prixDeRevient() > maxP)
                maxP = p.prixDeRevient();
        }

        double maxD = desserts.get(0).prixDeRevient();

        for (Plat p : desserts) {
            if (p.prixDeRevient() > maxD)
                maxD = p.prixDeRevient();
        }

        return maxE + maxP + maxD;

    }

  public boolean menuVegetariens() {
      for (Plat p : entrees) {
        if (p.contientViande()) return false;
    }
    for (Plat p : plats_principaux) {
        if (p.contientViande()) return false;
    }
    for (Plat p : desserts) {
        if (p.contientViande()) return false;
    }
    return true;
  }

  public boolean estAllergenne(String allergie){
    for (Plat p : entrees){
      if (p.getNomAllergenes.equals(allergie)) return false;
    }
    for (Plat p : plats_principaux){
      if (p.getNomAllergenes.equals(allergie)) return false ;
    }
    for (Plat p : desserts){
      if (p.getNomAllergenes.equals(allergie)) return false ;
    }
    return true;

  }

public List<String> allergenesObligatoires() {
    List<String> obligatoiresTotal = new ArrayList<>();
    if (entrees.size() > 0) {
        for (String allergene : entrees.get(0).getListeAllergenes()) {
            boolean presentDansToutes = true;
              for (Plat p : entrees) {
                if (!p.getListeAllergenes().equals(allergene)) {
                    presentDansToutes = false;
                }
            }
            if (presentDansToutes) {
                obligatoiresTotal.add(allergene);
            }
        }
    }
    if (plats_principaux.size() > 0 ) {
      for (String allergene : plats_principaux.get(0).getListeAllergenes()){
        boolean presentDansToutes = true ;
        for (Plat p : plats_principaux){
          if (!p.getListeAllergenes().equals(allergene)){
            presentDansToutes = false;
          }
        }
        if (presentDansToutes){
          obligatoiresTotal.add(allergenes);
        }
      }
    }

    if (desserts.size() > 0){
      for (String allergene : desserts.get(0).getListeAllergenes()){
        boolean presentDansToutes = true;
        for (Plat p : desserts){
          if (!p.getListeAllergenes().equals(allergene)){
            presentDansToutes = false;
          }
        }
        if (presentDansToutes){
          presentDansToutes = true;
        }
      }

    }

    return obligatoiresTotal;
}
}
