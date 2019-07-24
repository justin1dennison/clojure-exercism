(ns sublist)

(defn- equal-length? [xs ys]
  "Tests length equality"
  (= (count xs) (count ys)))

(defn- equal? [xs ys]
  "Determines whether the list x is equal to list y"
  (and (equal-length? xs ys)
       (= xs ys)))

(defn- chunk [n lst]
  (let [chunker (fn [idx _] (take n (drop idx lst)))]
    (->> lst
         (map-indexed chunker)
         (filter #(= (count %) n)))))

(defn superlist? [xs ys]
  (let [xlen (count xs)
        ylen (count ys)]
    (and (> xlen ylen)
         (->> xs
              (chunk ylen)
              (some #(equal? % ys))))))
           

(defn sublist? [xs ys]
  (superlist? ys xs))

(defn classify [fst snd]
  (cond 
    (equal? fst snd) :equal
    (superlist? fst snd) :superlist
    (sublist? fst snd) :sublist
    :else :unequal))
  
