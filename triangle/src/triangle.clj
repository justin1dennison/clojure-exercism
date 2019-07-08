(ns triangle)

(defn illogical? [sides]
  (let [[x y z] (sort sides)]
    (not (and 
      (< z (+ x y)) 
      (every? #(> % 0) sides)))))

(defn type [& sides]
  (let [distinct-sides (count (distinct sides))]
    (if (illogical? sides)
      :illogical
      (case distinct-sides
        1 :equilateral
        2 :isosceles
        3 :scalene))))
