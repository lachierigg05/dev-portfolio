
import ProjectCard from "./ProjectCard.tsx";
import {useEffect, useState} from "react";

interface Project {
    id: number,
    name: string,
    des: string,
    ImgUrl: string
}

const ProjectsCard: React.FC = () => {
    const [projects, setProjects] = useState<Project[]>([]);

    useEffect(() => {

    })

    return (
        <div className="w-1/2 h-screen">
            <div className="h-5/6 m-20 border-2 border-black rounded-lg overflow-auto scrollbar scrollbar-thumb-black scrollbar-track-gray-200 bg-gray-950">
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