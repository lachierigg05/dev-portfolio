import React from 'react';

interface Props {
    title: string;
    des?: string;
    imgSrc: string;
}
const ProjectCard: React.FC<Props> = ({title, des = "No Description", imgSrc}) => {
    return (
        <div className='m-8 h-1/2 w-7/8 text-white flex flex-col items-center border-white border-2 bg-gray-800'>
            <img src={imgSrc} alt='Project Image' className='w-4/6 h-3/6 mt-8 items-center'/>
            <h1 className='m-8 text-4xl'>{title}</h1>
            <p>{des}</p>
        </div>
    )
}

export default ProjectCard;