import React from 'react';
import ProjectCard from "./ProjectCard.tsx";

const ProjectsCard: React.FC = () => {
    return (
        <div className="w-1/2 h-screen">
            <div className="h-5/6 m-20 border-2 border-black rounded-lg overflow-auto scrollbar scrollbar-thumb-black scrollbar-track-gray-200">
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
                <ProjectCard title='Test' des='This is a test' imgSrc='src/assets/images/test.jpg'/>
            </div>
        </div>
    )
}

export default ProjectsCard;