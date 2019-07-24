(ns complex-numbers)

(defn real [[a b]] a)

(defn imaginary [[a b]] b)

(defn abs [[a b]] 
  (Math/sqrt
    (+ (* a a) (* b b))))

(defn conjugate [[a b]] [a (- b)])

(defn add [[a b] [c d]] [(+ a c) (+ b d)])

(defn sub [[a b] [c d]] [(- a c) (- b d)])

(defn mul [[a b] [c d]] 
 (let [real (- (* a c) (* b d))
       imag (+ (* b c) (* a d))]
   [real imag]))

(defn div [[a b] [c d]] 
  (let [real-top (float (+ (* a c) (* b d)))
        imag-top (float (- (* b c) (* a d)))
        bottom (float (+ (* c c) (* d d)))]
    [
     (/ real-top bottom)
     (/ imag-top bottom)
    ]))
