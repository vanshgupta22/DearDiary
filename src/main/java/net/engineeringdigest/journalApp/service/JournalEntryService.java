package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    JournalEntryRepository journalEntryRepository;

    public JournalEntry addJournal(JournalEntry journalEntry){
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllJournals(){
        return journalEntryRepository.findAll();
    }

}
