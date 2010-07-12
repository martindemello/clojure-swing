(ns swing.helpers.mouse
  (:import (SwingUtilities))
  (:import (java.awt.event MouseAdapter MouseListener KeyEvent)))

(defn- double-click?
  [event]
  (= 2 (.getClickCount event)))

(defn left-click?
  [event]
  (SwingUtilities/isLeftMouseButton event))

(defn right-click?
  [event]
  (SwingUtilities/isRightMouseButton event))

(defn center-click?
  [event]
  (SwingUtilities/isMiddleMouseButton event))

(defn add-mouse-clicked-listener
  [component f & args]
  (let [listener (proxy [MouseAdapter] []
                   (mouseClicked [event] (apply f event args)))]
    (.addMouseListener component listener)
    listener))
