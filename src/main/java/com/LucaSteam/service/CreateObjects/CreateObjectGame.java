package com.LucaSteam.service.CreateObjects;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;
import com.LucaSteam.service.GenreServiceImpl;
import com.LucaSteam.service.PlatformServiceImpl;
import com.LucaSteam.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateObjectGame {
    Game g = null;

    private static PlatformServiceImpl platformServiceImpl;
    private static GenreServiceImpl genreServiceImpl;
    private static PublisherServiceImpl publisherServiceImpl;

    @Autowired
    public CreateObjectGame(PlatformServiceImpl platformServiceImpl, GenreServiceImpl genreServiceImpl, PublisherServiceImpl publisherServiceImpl) {
        this.platformServiceImpl = platformServiceImpl;
        this.genreServiceImpl = genreServiceImpl;
        this.publisherServiceImpl = publisherServiceImpl;
    }

    public static Game createGame(String name, String platform, int year, String genre, String publisher, String sales) {
        System.out.println("save (POST)");
        Game g = new Game();
        String floatStr = sales;
        float floatVal = Float.parseFloat(floatStr);
        long longVal = (long) (floatVal * 100.0);
        g.setName(name);
        Platform p = platformServiceImpl.findByName(platform);
        Genre gen = genreServiceImpl.findByName(genre);
        Publisher pub = publisherServiceImpl.findByName(publisher);
        if (p == null) {
            p = new Platform();
            p.setName(platform);
            platformServiceImpl.save(p);
        }
        if (gen == null) {
            gen = new Genre();
            gen.setName(genre);
            genreServiceImpl.save(gen);
        }
        if (pub == null) {
            pub = new Publisher();
            pub.setPublisher_name(publisher);
            publisherServiceImpl.save(pub);
        }
        p = platformServiceImpl.findByName(platform);
        g.setPlatformId(p);
        g.setYear(year);
        g.setGenreId(gen);
        g.setPublisherId(pub);
        g.setSales(longVal);
        System.out.println(name);
        return g;
    }
}
