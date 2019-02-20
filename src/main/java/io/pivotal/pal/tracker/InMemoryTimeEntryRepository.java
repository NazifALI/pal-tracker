package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private ArrayList<TimeEntry> timeDatabase;

    public InMemoryTimeEntryRepository() {
        this.timeDatabase = new ArrayList<TimeEntry>();
    }

    public TimeEntry create(TimeEntry timeEntry){
        if(this.timeDatabase.isEmpty()) {
            timeEntry.setId(1);
        } else{
            timeEntry.setId(this.timeDatabase.size() + 1);
        }
        timeDatabase.add(timeEntry);
        return timeDatabase.get(timeDatabase.size() - 1);
    }

    public TimeEntry find(Long id){
        for(int i = 0; i < timeDatabase.size(); i++){
            if(timeDatabase.get(i).getId() == id)
                return timeDatabase.get(i);
        }
        return null;
    }

    public List<TimeEntry> list(){
        return timeDatabase;
    }

    public TimeEntry update(Long id, TimeEntry timeEntry){
        for(int i = 0; i < timeDatabase.size(); i++){
            if(timeDatabase.get(i).getId() == id) {
                timeDatabase.get(i).setDate(timeEntry.getDate());
                timeDatabase.get(i).setProjectId(timeEntry.getProjectId());
                timeDatabase.get(i).setUserId(timeEntry.getUserId());
                timeDatabase.get(i).setHours(timeEntry.getHours());
                return timeDatabase.get(i);
            }
        }
        return null;
    }

    public void delete(Long id){
        for(int i = 0; i < timeDatabase.size(); i++){
            if(timeDatabase.get(i).getId() == id)
                timeDatabase.remove(i);
        }
    }

}
