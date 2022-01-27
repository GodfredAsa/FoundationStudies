package com.company.SOLID_Principle.LiskovSubstitutionPrinciple;

abstract public class SocialMedia {

    // @support WhatsApp, Facebook, Instagram
    public abstract void chatWithFriends();

    // @support  Facebook, Instagram
    public abstract void publishPost(Object post);


    // @support WhatsApp, Facebook, Instagram
    public abstract void sendPhotosAndVideos();

    // @support WhatsApp, Facebook
    public abstract void groupVideoCalls(String... users);
}
