package com.example.parkapp.http;

import java.util.List;

public class PlateResult {

    /**
     * log_id : 4294080888431451782
     * words_result : {"color":"blue","number":"京A63083","probability":[0.901121199131012,0.901360809803009,0.9003618359565735,0.901297926902771,0.9019075036048889,0.9010767340660095,0.9012012481689453],"vertexes_location":[{"y":2931,"x":566},{"y":2933,"x":1986},{"y":3325,"x":1986},{"y":3321,"x":566}]}
     */

    private long log_id;
    private WordsResultBean words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public WordsResultBean getWords_result() {
        return words_result;
    }

    public void setWords_result(WordsResultBean words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * color : blue
         * number : 京A63083
         * probability : [0.901121199131012,0.901360809803009,0.9003618359565735,0.901297926902771,0.9019075036048889,0.9010767340660095,0.9012012481689453]
         * vertexes_location : [{"y":2931,"x":566},{"y":2933,"x":1986},{"y":3325,"x":1986},{"y":3321,"x":566}]
         */

        private String color;
        private String number;
        private List<Double> probability;
        private List<VertexesLocationBean> vertexes_location;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public List<Double> getProbability() {
            return probability;
        }

        public void setProbability(List<Double> probability) {
            this.probability = probability;
        }

        public List<VertexesLocationBean> getVertexes_location() {
            return vertexes_location;
        }

        public void setVertexes_location(List<VertexesLocationBean> vertexes_location) {
            this.vertexes_location = vertexes_location;
        }

        public static class VertexesLocationBean {
            /**
             * y : 2931
             * x : 566
             */

            private int y;
            private int x;

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }
        }
    }
}
