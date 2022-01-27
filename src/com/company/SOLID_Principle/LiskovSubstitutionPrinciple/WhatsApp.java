package com.company.SOLID_Principle.LiskovSubstitutionPrinciple;

public class WhatsApp extends SocialMedia{
    @Override
    public void chatWithFriends() {

    }

    @Override
    public void publishPost(Object post) {
        // not applicable
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCalls(String... users) {

    }
}
