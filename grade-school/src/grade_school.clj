(ns grade-school)

(defn grade [school grade]
  (if (contains? school grade)
    (get school grade)
    []))

(defn add [school name grade]
  (if (contains? school grade)
    (assoc
     school
     grade
     (conj (get school grade) name))
    (assoc school grade [name])))

(defn sorted [school]
  (into 
    (sorted-map) 
    (for [k (keys school)] 
      [k (vec (sort (school k)))])))