package com.mycompany.dvdstore.repository.file;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.repository.FilmRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FichierFilmRepository implements FilmRepositoryInterface {

    //variable de type fichier
    @Value("${films.file.location}")
    private File file;
    //getter//setter
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }

    public Film save(Film film){

        //permet d'incrémenter le dernier ID pour un ajout de film
        long lastId= StreamSupport.stream(findAll().spliterator(), false).map(Film::getId).max(Long::compare).orElse(10L);

        film.setId(lastId+1);
        FileWriter writer;
        try{
            //on instancie writer avec la variable donc la valeur est dans l'ApplicationContext
            writer=new FileWriter(file,true);
            writer.write(film.getId()+";"+film.getTitre()+";"+film.getGenre()+";"+film.getDescription()+"\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.printf("Le film %s a été ajouté.",film.getTitre());
        return film;
    }

    @Override
    public <S extends Film> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Film> findAll() {

        List<Film> films=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Film film=new Film();
                final String[] titreEtGenre = line.split(";");
                film.setId(Long.parseLong(titreEtGenre[0]));
                film.setTitre(titreEtGenre[1]);
                film.setGenre(titreEtGenre[2]);

                films.add(film);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Un film du fichier n'a pas d'id");
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public Iterable<Film> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Film> findById(Long id) {
        final Film film = new Film();
        film.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextFilmId=Long.parseLong(allProperties[0]);
                if (nextFilmId==id) {
                    film.setTitre(allProperties[1]);
                    film.setGenre(allProperties[2]);
                    film.setDescription(allProperties[3]);
                    return Optional.of(film);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        film.setTitre("UNKNOWN");
        film.setGenre("UNKNOWN");
        film.setDescription("UNKNOWN");
        return Optional.of(film);
    }

    @Override
    public void delete(Film film) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Film> iterable) {

    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Film> findById(long id) {
        return Optional.empty();
    }
}

