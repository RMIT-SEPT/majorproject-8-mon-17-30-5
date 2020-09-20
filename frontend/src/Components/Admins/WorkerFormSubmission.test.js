import React from 'react';
import { configure } from 'enzyme';
import WorkerForm from './WorkerForm';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

configure({ adapter: new Adapter() });

it("render admin adding worker form correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerForm/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(2);
})

// test('Call onSubmit props for form submission', () => {
//     const workerInfo = {
//         firstName: "Sara",
//         lastName: "Tran",
//         username: "sara.tran123",
//         password: "0123456789"
//     }
  
//     const onSubmitSpy = jest.fn();
  
//     const wrapper = shallow(
//       <WorkerForm workerInfo={workerInfo} onSubmit={onSubmitSpy} />
//     );
  
//     wrapper.find('form').simulate('submit', { preventDefault: () => {} });
  
//     expect(wrapper.state('value')).toBe('');
//     expect(onSubmitSpy).toHaveBeenLastCalledWith({
//       firstName: workerInfo.firstname,
//       lastName: workerInfo.lastname,
//       username: workerInfo.username,
//       password: workerInfo.password
//     });
//   });