(ns pascals-triangle)

(defn factorial [n] 
  (reduce * 1 
      (map bigint (range 2 (inc n)))))

(defn n-choose-k [n k]
  (/ (factorial n) 
     (* 
       (factorial k) 
       (factorial (- n k)))))

(def triangle 
  (lazy-seq 
    (for [row (range)] 
      (map #(n-choose-k row %) (range (inc row))))))

(defn row [n]
  (nth triangle (dec n)))
 

