 static boolean alert(int[] inputs, int windowSize, float allowedIncrease) {
        int length = inputs.length;
        double prev = Integer.MAX_VALUE;
        double prevMin = Integer.MAX_VALUE;
        int prevMax = Integer.MIN_VALUE;
        int nComMax = 0;

        for (int i = windowSize; i < length; i++) {
            double avg = 0.0d;
            int s = 0;
            int max = Integer.MIN_VALUE;
            for (int index = windowSize; index > 0; index--) {
                s += inputs[i - index];
                if (max < inputs[i - index]) {
                    max = inputs[i - index];
                }
            }
            avg = s / windowSize;
            double d = max / avg;
            if (max == prevMax && d <= allowedIncrease) {
                nComMax = -1 * windowSize;
            } else if (max == prevMax && d > allowedIncrease) {
                nComMax++;
            } else {
                if (nComMax > 0) {
                    return true;
                }
                if (d > allowedIncrease) {
                    nComMax = 1;
                }
            }
            if (avg / prev > allowedIncrease) {
                return true;
            }
            prev = avg;
            if (avg < prevMin) {
                prevMin = avg;
            }

            if (avg / prevMin > allowedIncrease) {
                return true;
            }
        }

    
        return false;
    }
