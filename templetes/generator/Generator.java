import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Random;

public class Generator {
    public static void main(String[] args) throws IOException {

        String[] activations = {"relu", "sigmoid", "tanh", "softmax", "none"};

        // 1) 인자 체크
        // if (args.length < 2) {
        //     System.err.println("사용법: java Generator <행렬개수> <출력파일.txt>");
        //     System.exit(1);
        // }

        int matrixCount = Integer.parseInt(args[0]);
        Path outPath = Paths.get(args[1]);

        Random rnd = new Random();

        // 2) 곱셈 가능한 차원 시퀀스 만들기
        //    d[0], d[1], ..., d[matrixCount]
        //    i번째 행렬의 크기 = d[i] x d[i+1]
        int[] dims = new int[matrixCount + 1];
        for (int i = 0; i < dims.length; i++) {
            dims[i] = 16; 
        }

        StringBuilder sb = new StringBuilder();

        // 3) 첫 줄: 행렬 개수
        sb.append(matrixCount).append("\n");

        // 4) 각 행렬 생성
        for (int m = 0; m < matrixCount; m++) {
            int rows = dims[m];
            int cols = dims[m + 1];

            // "행 개수 열 개수"
            sb.append(rows).append(" ").append(cols).append("\n");

            // 활성화 함수
            sb.append(activations[4]).append("\n");

            // 실제 행렬 값 (0 ~ 127)
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int val = rnd.nextInt(9); // 0~9
                    sb.append(val);
                    if (j < cols - 1) sb.append(" ");
                }
                sb.append("\n");
            }

        }

        // 5) 파일로 저장
        Files.writeString(outPath, sb.toString(), StandardCharsets.UTF_8);
    }
}
