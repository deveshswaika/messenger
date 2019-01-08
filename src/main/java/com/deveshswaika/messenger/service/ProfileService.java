package com.deveshswaika.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deveshswaika.messenger.database.DatabaseClass;
import com.deveshswaika.messenger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Devesh",new Profile(1,"Devesh","Devesh","Swaika"));
		profiles.put("Rajesh",new Profile(2,"Rajesh","Rajesh","Agarwal"));
	}
	
    public List<Profile> getAllProfiles() {
    	return new ArrayList<Profile>(profiles.values());
    }
    public Profile getProfile(String profileName) {
    	return profiles.get(profileName);
    }
    public Profile addProfile(Profile profile) {
    	profile.setId(profiles.size()+1);
    	profiles.put(profile.getProfileName(),profile);
    	return profile;
    }
    public Profile updateProfile(Profile profile) {
    	if(profile.getProfileName().isEmpty())
    		return null;
    	profiles.put(profile.getProfileName(), profile);
    	return profile;
    		
    }
    public Profile removeProfile(String profileName) {
    	return profiles.remove(profileName);
    }
	
	
	

}
