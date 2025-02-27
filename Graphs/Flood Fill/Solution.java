class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original_color = image[sr][sc];
        if (original_color == color) {
            return image;
        }

        image[sr][sc] = color;

        // up
        if (sr - 1 >= 0 && image[sr - 1][sc] == original_color)
            image = floodFill(image, sr - 1, sc, color);

        // down
        if (sr + 1 < image.length && image[sr + 1][sc] == original_color)
            image = floodFill(image, sr + 1, sc, color);

        // left
        if (sc - 1 >= 0 && image[sr][sc - 1] == original_color)
            image = floodFill(image, sr, sc - 1, color);

        // right
        if (sc + 1 < image[0].length && image[sr][sc + 1] == original_color)
            image = floodFill(image, sr, sc + 1, color);

        return image;
    }
}