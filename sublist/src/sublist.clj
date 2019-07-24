(ns sublist)

(defn superlist? [xs ys]
   (->> xs
        (partition (count ys) 1)
        (some #(= % ys))))

(defn sublist? [xs ys]
  (superlist? ys xs))

(defn classify [fst snd]
  (cond 
    (= fst snd) :equal
    (superlist? fst snd) :superlist
    (sublist? fst snd) :sublist
    :else :unequal))
  
