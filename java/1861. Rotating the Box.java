class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = rotate(box);
        for (int j = 0; j < rotated[0].length; j++) {
            int lowest = rotated.length-1;
            for (int i = rotated.length-1; i >= 0; i--) {
                if (rotated[i][j] == '*') {
                    lowest = i-1;
                } else if (rotated[i][j] == '#') {
                    rotated[i][j] = '.';
                    rotated[lowest][j] = '#';
                    while (lowest >= i && rotated[lowest][j] != '.') {
                        lowest--;
                    }
                }
            }
        }
        return rotated;
    }
    private char[][] rotate(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                result[j][i] = box[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length/2; j++) {
                char temp = result[i][j];
                result[i][j] = result[i][result[i].length-1-j];
                result[i][result[i].length-1-j] = temp;
            }
        }
        return result;
    }
}

