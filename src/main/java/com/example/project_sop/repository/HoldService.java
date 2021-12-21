package com.example.project_sop.repository;

import com.example.project_sop.pojo.Hold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoldService {
    @Autowired
    private HoldRepository repository;

    public HoldService(HoldRepository repository) {
        this.repository = repository;
    }

    public Hold retrieveHoldBookByUsername(String username) {
        return repository.findHoldBookByUsername(username);
    }

    public Hold retrieveHoldBookByTitle(String title) {
        return repository.findHoldBookByTitle(title);
    }

    public Hold retrieveHoldBookByID(String _id) {
        return repository.findHoldBookByID(_id);
    }

    public Hold createHoldBook(Hold hold) {
        return repository.save(hold);
    }

    public boolean deleteHoldBook(Hold hold) {
        try {
            repository.delete(hold);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
