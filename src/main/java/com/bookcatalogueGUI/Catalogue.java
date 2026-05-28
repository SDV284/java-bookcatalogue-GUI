package com.bookcatalogueGUI;

import java.io.*;
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

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                this.publications = new ArrayList<>();

                for (Object item : (List<?>) obj) {
                    if (item instanceof Publication) {
                        this.publications.add((Publication) item);
                    }
                }
            }
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(publications);
        }
    }
}