package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RecoveryRoomService {
	@Autowired
	private RecoveryRoomRepository recRepository;
	@Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return recRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }
    @Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recRepository.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return recRepository.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }

    
}
