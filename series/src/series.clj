(ns series)

(defn n-tuple [string length]
  (loop [iter 0 results []]
    (if (= iter (- (count string) 2))
      results
      (recur 
        (inc iter) 
        (conj results (subs string iter (+ iter length)))))))

(defn slices [string length] 
  (let [str-length (count string)]
    (cond
      (< str-length length) []
      (zero? str-length) []
      :else (n-tuple string length))))
