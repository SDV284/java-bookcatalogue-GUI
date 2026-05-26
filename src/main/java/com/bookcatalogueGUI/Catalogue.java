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

    public Publication findPublicationByTitle(String title) {
        for (Publication p : publications) {
            if (p.getTitle().equalsIgnoreCase(title.trim())) {
                return p;
            }
        }
        return null;
    }

    public void removePublicationByTitle(String title) throws BookNotFoundException {
        Publication toRemove = findPublicationByTitle(title);
        if (toRemove == null) {
            throw new BookNotFoundException("Публікацію з назвою \"" + title + "\" не знайдено.");
        }
        publications.remove(toRemove);
    }
}