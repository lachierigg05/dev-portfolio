import React, { useEffect } from 'react';
import DevProfileCard from "./components/DevProfileCard.tsx";
import '../index.css'
import ProjectsCard from "./components/ProjectsCard.tsx";

const App: React.FC = () => {
  useEffect(() => {
    const handleMouseMove = (event: MouseEvent) => {
      const flashlight = document.getElementById('flashlight');
      if (flashlight) {
        flashlight.style.left = `${event.clientX}px`;
        flashlight.style.top = `${event.clientY}px`;
      }
    };

    window.addEventListener('mousemove', handleMouseMove);
    return () => {
      window.removeEventListener('mousemove', handleMouseMove);
    };
  }, []);

  return (
    <div className="w-full h-full flex justify-start">
      <DevProfileCard />
      <ProjectsCard />
      <div id="flashlight" className="flashlight"></div>
    </div>
  );
};

export default App;