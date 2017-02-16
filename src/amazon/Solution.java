package amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by j_rus on 5/4/2016.
 */
public class Solution {
    public static class Movie {
        private final int movieId;
        private final float rating;
        private List<Movie> similarMovies; // Similarity is bidirectional

        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }

        public int getId() {
            return movieId;
        }

        public float getRating() {
            return rating;
        }

        public void addSimilarMovie(Movie movie) {
            similarMovies.add(movie);
            movie.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }

    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {

        List<Movie> results = new ArrayList<>();
        List<Float> ratings = new ArrayList<>();
        List<Float> topRated = new ArrayList<>();

        if(movie != null){
            if(movie.getSimilarMovies() != null ||!movie.getSimilarMovies().isEmpty()){
                for(Movie mv : movie.getSimilarMovies()){
                    ratings.add(mv.getRating());
                }
                Collections.sort(ratings);
                Collections.reverse(ratings);
                for(int i=0; i<= numTopRatedSimilarMovies-1; i++){
                    topRated.add(ratings.get(i));
                }
                for(Movie mv : movie.getSimilarMovies()){
                    for(Float rt : topRated)
                    if(mv.getRating() == rt) {
                        results.add(mv);
                    }
                }
            }
        }
        return results;
    }
    public static void main(String[] args) throws IOException {
        final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
        Movie rootMovie = null;
        int numTopRatedSimilarMovies = 0;

        final Scanner in = new Scanner("# Declare movies: Id Rating\n" +
                "movie 1 1.2\n" +
                "movie 2 3.6\n" +
                "movie 3 2.4\n" +
                "movie 4 4.8\n" +
                "\n" +
                "# Declare similarities: FirstMovie SecondMovie\n" +
                "similar 1 2\n" +
                "similar 1 3\n" +
                "similar 2 4\n" +
                "similar 3 4\n" +
                "\n" +
                "# Declare params: Movie NumTopRatedSimilarMovies\n" +
                "params 1 2");
        in.useLocale(new Locale("en", "US"));

        while (in.hasNextLine()) {
            final String type = in.next();

            if (type.equals("movie")) {
                final int id = in.nextInt();
                final float rating = in.nextFloat();
                movieMap.put(id, new Movie(id, rating));
            } else if (type.equals("similar")) {
                final Movie movie1 = movieMap.get(in.nextInt());
                final Movie movie2 = movieMap.get(in.nextInt());
                movie1.addSimilarMovie(movie2);
            } else if (type.equals("params")) {
                rootMovie = movieMap.get(in.nextInt());
                numTopRatedSimilarMovies = in.nextInt();
            } else {
                // ignore comments and whitespace
            }
        }

        final List<Movie> result = getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);


        String output = "result";

        if (result == null) {
            output += " <null>";
        } else {
            Collections.sort(result, new Comparator() {
                @Override
                public int compare(Object m1, Object m2) {
                    return ((Movie)m1).getId() - ((Movie)m2).getId();
                }
            });

            for (Movie m: result) {
                output += " ";
                output += m.getId();
            }
        }

        final String fileName = System.getenv("C://Users//j_rus//Downloads//test_cases_eqjg118hj50//input001.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(output);
        bw.newLine();
        bw.close();
    }
}
