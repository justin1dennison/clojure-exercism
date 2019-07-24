(ns complex-numbers)

(defn- sum-of-squares [[a b]]
  (+ (* a a) (* b b)))

(defn real [[a b]] a)

(defn imaginary [[a b]] b)

(defn abs [[a b]] 
  (->> [a b]
       sum-of-squares
       Math/sqrt))

(defn conjugate [[a b]] [a (- b)])

;; inspired from other solutions
(def add (partial map +))

(def sub (partial map -))

(defn process [[a b] [c d]]
  [[(* a c) (* b d)]
   [(* b c) (* a d)]])
  
(defn mul [[a b] [c d]] 
 (let [[real imag] (process [a b] [c d])]
   [(apply - real) (apply + imag)]))

(defn div [[a b] [c d]] 
  (let [[real imag] (process [a b] [c d])
        real-top (apply + real )
        imag-top (apply - imag)
        bottom (sum-of-squares [c d])]
    (when-not (= 0 c d)
      (map double [(/ real-top bottom) (/ imag-top bottom)]))))
