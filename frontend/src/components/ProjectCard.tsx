import React from 'react';

interface Props {
    title: string;
    des?: string;
    imgSrc: string;
}
const ProjectCard: React.FC<Props> = ({title, des = "No Description", imgSrc}) => {
    return (
        <div className='m-2 h-1/2 w-full text-white flex  flex-col border-white border-2'>
            <img src={imgSrc} alt='Project Image' className='w-5/6 h-24 items-center'/>
            <h1>{title}</h1>
            <p>{des}</p>
        </div>
    )
}

export default ProjectCard;