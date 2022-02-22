Vous trouverez ci-joint des exemples de données
qui seront utilisées pour tester votre programme
lors de la correction.

Votre programme doit pouvoir lire ces fichiers à
partir de leur chemin d'accès et construire les objets.
Ces chemins d'accès seront fournis en argument à votre programme.

/*
 * args[0] contiendra l'adresse du fichier des chauffeurs
 * args[1] contiendra l'adresse du fichier des limousines
 * args[2] contiendra l'adresse du fichier des trajetsq
 */
public static void main(String[] args){...}


Dans chaque ligne, les éléments
sont séparés par une tabulation ('\t').
	Indice: voir la méthode String.split()
	
Lors de la correction, votre programme sera testé avec d'autres
fichiers. Il pourrait y avoir plus ou moins de lignes dans
les fichiers de correction.

Le fichiers Exemples_Donnees.xlsx est fourni à titre indicatif
seulement et présente les en-têtes des colonnes.


Indications supplémentaires:
	
	Chauffeurs:
		Le numéro d'identification
		Votre programme doit
		le générer	à partir des autres informations.
		
		Le nom et le prénom pourraient contenir
		une apostrophe ('), un trait d'union (-)
		ou un espace ( ). Ces caractères ne
		doivent pas faire partie du numéro
		d'identification.
		
		Il n'est pas nécessaire de gérer la situation ou
		deux chauffeurs auraient le même numéro
		d'identification. On ne va pas soummettre
		de telles données confictuelles à votre
		programme. Vous pouvez considérer que le
		numéro d'identification est unique.
		
		Il n'est pas nécessaire que le numéro d'identification
		soit sensible à la casse.
		
	Trajets:
		Les trajets devraient être lus après les chauffeurs et les
		limousines. Vous devriez donc pouvoir
		ajouter la bonne limousine au trajet à
		partir du numéro d'immatriculation. Vous
		pourrez ajouter le trajet au bon
		chauffeur à partir de son numéro
		d'identification.
		
Conseils :

	Il est déconseillé de modifier ces données de test pour l'adapter
	à votre programme. Il est inutile de joindre ces données de test
	dans votre devoir.
	
	Lorsque vous testerez votre programme avant de le déposer,
	téléchargez de nouveau ce jeu de données au cas où vous auriez
	fait une modification.

	