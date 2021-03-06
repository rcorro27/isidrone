package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCategory;
import util.Restriction;
import util.ResultValidation;
import util.Validation;

public class ActionCategory {
	
	public static void getCategories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("categories", MCategory.getCategories());
	}
	
	public static int getSelectedCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Permet de recevoir la catégorie sélectionné par l'utilisateur
		String paramCategory = request.getParameter("category");
		
		//ArrayList<Category> categories = MCategory.getCategories();
		int categorySelected;

		if(paramCategory != null) {
			try {
				//Si l'utilisateur entre lui même une valeur pour le paramêtre category dans la barre d'adresse
				// alors s'il la catégorie est invalide, alors la catégorie sélectionné deviendra 1 (qui représente toutes les catégories)
				categorySelected = Integer.valueOf(paramCategory);
				if(MCategory.isExist(categorySelected) != 0)
					categorySelected = 1;
			}
			catch(NumberFormatException e) {
				categorySelected = 1;
			}
		}
		else
			categorySelected = 0;
		
		return categorySelected;
	}

        public static boolean addCategory(HttpServletRequest request, HttpServletResponse response){
            String[] s_formParamsNeeded = {"name", "description", "order", "isActive"};
				
		String[] s_formValuesNeeded = {
			request.getParameter(s_formParamsNeeded[0]),
			request.getParameter(s_formParamsNeeded[1]),
			request.getParameter(s_formParamsNeeded[2]),
			request.getParameter(s_formParamsNeeded[3]),
			};
		
		
		boolean isCompleted = true;
		
		//HashMap des données obligatoire
		HashMap<String, String> hm_formParamValue = new HashMap<String, String>();
		for(int i=0; i< s_formValuesNeeded.length; i++) {
			hm_formParamValue.put(s_formParamsNeeded[i], s_formValuesNeeded[i]);
		}
            
            
        
        return false;
        }
        
        public static boolean validateForm(HashMap<String, String> hm_formParamValue, HttpServletRequest request) {
		//On créer un HashMap pour contenir les potiennelles message d'erreurs
		HashMap<String, String> hm_fieldErrorMsg = new HashMap<String, String>();
		
		//Création des restriction de validation
		//Restriction restrict1 = new Restriction(1, 45, Pattern.compile("^([a-zA-ZàéèêâïçÀÉÈÊÏÇ])+([ -][a-zA-ZàéèêâïçÀÉÈÊÏÇ]+)*"));
		
		//Restriction restrictEmail = new Restriction(1, 45, Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"));
		//Restriction restrictConfirmEmail = new Restriction(hm_formParamValue.get("email"));
		
		//Restriction restrictPassword = new Restriction(8, 40, Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$"));
		//Restriction restrictConfirmPassword = new Restriction(hm_formParamValue.get("password"));
		
		Restriction restrictAddr_no = new Restriction(1, 10, Pattern.compile("[a-zA-z0-9]*"));
                Restriction restrict1 = new Restriction(1, 45, Pattern.compile("^([a-zA-ZàéèêâïçÀÉÈÊÏÇ])+([ -][a-zA-ZàéèêâïçÀÉÈÊÏÇ]+)*"));

		
		
		//Création d'un objet Validation et ajout des restrictions à ce dernier
		Validation validation = new Validation(hm_formParamValue);
		
		validation.addRestriction("name", restrict1);
                validation.addRestriction("description", restrictAddr_no);
                validation.addRestriction("order", restrictAddr_no);
                validation.addRestriction("isActive", restrictAddr_no);
                
		
		
		//On conserve les résultat des tests
		ArrayList<ResultValidation> resultValidations = validation.validate();
		//On parcours les résultat des tests
		for(ResultValidation rv : resultValidations) {
			//Si le test ne passe pas, alors on ajoute un message d'erreur
			if(rv.getCode() != 0)
				hm_fieldErrorMsg.put(rv.getKey(), getErrorMsg(rv));
		}
		
		//On passe le hashMap en attribut à la requête
		request.setAttribute("hm_fieldErrorMsg", hm_fieldErrorMsg);

		return validation.isValidate();
	}
        private static String getErrorMsg(ResultValidation resValid) {
		String errorMsg = "";
		switch(resValid.getKey()) {
			case "lastName":
				errorMsg += getErrorMsgForLastName(resValid);
				break;
			case "firstName":
				errorMsg += getErrorMsgForFirstName(resValid);
				break;
			case "email":
				errorMsg += getErrorMsgForEmail(resValid);
				break;
			case "confirmEmail":
				errorMsg += getErrorMsgForConfirmEmail(resValid);
				break;
			
		}
		
		return errorMsg;
	}
	
	private static String getErrorMsgForLastName(ResultValidation resValid) {
		String errorMsg = "";
		Restriction restriction = resValid.getRestriction();
		
		switch(resValid.getCode()) {
			case 1:
				errorMsg += "Vous devez remplir le champ nom.\n";
				break;
			case 2:
			case 3:
				errorMsg += "Vous devez saisir entre "+restriction.getMinLength()+ " et "+restriction.getMaxLength()+" caractère(s).\n";
				break;
			case 4:
				errorMsg += "Lettre seulement, pas de chiffre ou de caractère spéciaux. Espace et trait d'union accepté, sauf s'ils ont au début ou à la fin du nom)";
				break;
			case 5:
				break;
		}
		
		return errorMsg;
	}
	
	private static String getErrorMsgForFirstName(ResultValidation resValid) {
		String errorMsg = "";
		Restriction restriction = resValid.getRestriction();
		
		switch(resValid.getCode()) {
			case 1:
				errorMsg += "Vous devez remplir le champ prénom.\n";
			case 2:
			case 3:
				errorMsg += "Vous devez saisir entre "+restriction.getMinLength()+ " et "+restriction.getMaxLength()+" caractère(s).\n";
			case 4:
				errorMsg += "Lettre seulement, pas de chiffre ou de caractère spéciaux. Espace et trait d'union accepté, sauf s'ils ont au début ou à la fin du nom)";
				break;
			case 5:
				break;
		}
		
		return errorMsg;
	}
	
	private static String getErrorMsgForEmail(ResultValidation resValid) {
		String errorMsg = "";
		Restriction restriction = resValid.getRestriction();
		
		switch(resValid.getCode()) {
			case 1:
				errorMsg += "Vous devez remplir le champ email.\n";
			case 2:
			case 3:
				errorMsg += "Vous devez saisir entre "+restriction.getMinLength()+ " et "+restriction.getMaxLength()+" caractère(s).\n";
			case 4:
				errorMsg += "Veuillez entrez une adresse e-mail valide";
			case 5:
				break;
                    }
		
		return errorMsg;
	}
	
	private static String getErrorMsgForConfirmEmail(ResultValidation resValid) {
		String errorMsg = "";
		
		switch(resValid.getCode()) {
			case 1:
				errorMsg += "Vous devez remplir le champ de confirmation pour l'adresse email.\n";
				break;
			case 2:
			case 3:
			case 4:
			case 5:
				errorMsg += "L'adresse email ne correspond pas avec la confirmation de l'adresse email.";
				break;
		}
		
		return errorMsg;
	}
        
        //
        public static boolean deleteCategory(HttpServletRequest request, int id) throws IOException{
            return MCategory.deleteCategorie(id);
        }

}
