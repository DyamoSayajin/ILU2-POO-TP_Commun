package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
		initialiserCalendrier();
	}
	
	public static class Mois{
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom, boolean[] jours) {
			this.nom = nom;
			this.jours = jours;
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour];
		}
		
		private void reserver(int jour) {
			if(!estLibre(jour)) {
				throw new IllegalStateException("Ce jour n'est pas libre");
			}
			jours[jour] = true;
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		if(estLibre(jour, mois)) {
			calendrier[mois-1].reserver(jour-1);
			return true;
		}
		return false;
	}
	
	private void initialiserCalendrier() {
		calendrier[0] = new Mois("Janvier", new boolean[31]);
		calendrier[1] = new Mois("Février", new boolean[28]);
		calendrier[2] = new Mois("Mars", new boolean[31]);
		calendrier[3] = new Mois("Avril", new boolean[30]);
		calendrier[4] = new Mois("Mai", new boolean[31]);
		calendrier[5] = new Mois("Juin", new boolean[30]);
		calendrier[6] = new Mois("Juillet", new boolean[31]);
		calendrier[7] = new Mois("Août", new boolean[31]);
		calendrier[8] = new Mois("Septembre", new boolean[30]);
		calendrier[9] = new Mois("Octobre", new boolean[31]);
		calendrier[10] = new Mois("Novembre", new boolean[30]);
		calendrier[11] = new Mois("Décembre", new boolean[31]);
	}
}