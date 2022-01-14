package org.springframework.samples.petclinic.recoveryroom;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	private static final String VIEWS_RECOVERYROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private static final String WELCOME_VIEW = "welcome";
	private final RecoveryRoomService ps;
	
	public RecoveryRoomController(RecoveryRoomService ps) {
		this.ps = ps;
	}
	
	 
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryroom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryroom);
		return VIEWS_RECOVERYROOMS_CREATE_OR_UPDATE_FORM;
	}
    
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("recoveryRoom", recoveryRoom);
			return VIEWS_RECOVERYROOMS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.ps.save(recoveryRoom);

			return WELCOME_VIEW;
		}
	}
}
