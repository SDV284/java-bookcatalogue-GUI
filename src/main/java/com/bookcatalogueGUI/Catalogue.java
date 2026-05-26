package com.bookcatalogueGUI;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<Publication> publications;

    public Catalogue() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication p) {
        publications.add(p);
    }

    public List<Publication> getAllPublications() {
        return new ArrayList<>(publications);
    }
}